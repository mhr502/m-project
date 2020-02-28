package app.controller.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import app.bean.Board;
import app.bean.Member;
import app.repository.BoardRepo;

/**
 * Servlet implementation class BoardAddServlet
 */
//게시물을 추가할때 이용하는 서블릿
@WebServlet("/board/add")
@MultipartConfig
public class BoardAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// view path
	private final String view = "/WEB-INF/view/board/add.jsp";
	
	// repos
	private BoardRepo repo;
	
	@Override
	public void init() throws ServletException {
		super.init();
		repo = new BoardRepo();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("loginUser");
		
		if (m != null) {
			// 로그인 된 경우
			request.getRequestDispatcher(view).forward(request, response);
		} else {
			// 로그인 안된 경우
			response.sendRedirect(request.getContextPath() 
					+ "/member/login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("loginUser");
		
		// get req parameters
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		
		Part filePart= request.getPart("file");//input element인 "file"을 꺼내서 사용
		String fileName = filePart.getSubmittedFileName();
		
		//create Board instance
		Board board = new Board();
		board.setTitle(title);
		board.setBody(body);
		board.setFileName(fileName);
		board.setMemberId(m.getMemberId());
		
		
		// insert db
		//boolean ok = repo.addBoard(title, body, m.getMemberId());
		repo.addBoard(board);
		
		System.out.println(board);
		
		//store file
		createFile(filePart,board);//board객체가 id를 가지고 있음.
		
		// forward or redirect
		if (board.getId() !=0) {
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("title", title);
			request.setAttribute("body", body);
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		
	}

	private void createFile(Part filePart, Board board) {
		ServletContext app =getServletContext();
		String contextRoot = app.getContextPath();
		//application의 다른 이름이 servletContext!
		String filePath =
				"K:/myworkspace/eclipse-workspace/static"
				+ contextRoot + "/" + board.getId();
//board.getId가 파일이 들어갈 위치		
		
		File fileDir = new File(filePath);
		
		if(!fileDir.exists()) {
			fileDir.mkdirs(); //폴더 안에 파일 생성을 하기위해 디렉토리들을 만듬.
			
		}
		try {		
			filePart.write(filePath +"/"+ filePart.getSubmittedFileName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
 //filePart.write(*) *-->이 파일 이름으로 저장이된다는 뜻
		
		
	}
	
	
	
	
	

}








