package redt.app.controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import redt.app.exception.NoBooksException;
import redt.app.model.Book;
import redt.app.model.MyBooks;
import redt.app.service.Books.BooksManager;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("MyBooks")
public class HomeController {

	@Autowired
	private BooksManager booksManager;

	@Autowired
	private HttpSession httpSession;

	@ModelAttribute("MyBooks")
	public MyBooks getMyBooks(Model model){
		return new MyBooks();
	}

	@GetMapping("/")
	public String index(Model model){
		List<Book> list = booksManager.getList();
		model.addAttribute("list", list);
		return "index";
	}

	@GetMapping("/{id}")
	public String muon(@PathVariable("id") int id) throws NoBooksException {
		List<Book> list = booksManager.getList();
		boolean check = false;
		for (Book book: list){
			if (book.getId() == id){
				if (book.getNumber() > 0){
					MyBooks myBooks = (MyBooks) httpSession.getAttribute("MyBooks");
					myBooks.add(book);
					book.minus();
					check = true;
				}else{
					throw new NoBooksException("Sách đã hết, không thể mượn.");
				}
				break;
			}
		}
		if (check == false) throw new NoBooksException("ID sách không đúng.");
		return "redirect:/";
	}

	@GetMapping("/tra/{id}")
	public String tra(@PathVariable("id") int id) throws NoBooksException {
		MyBooks myBooks = (MyBooks) httpSession.getAttribute("MyBooks");

		boolean check = false;

		List<Book> list = myBooks.getList();
		for (Book book: list){
			if (book.getId() == id){
				myBooks.remove(book);
				book.plus();
				check = true;
			}
			break;
		}
		if (check == false) throw new NoBooksException("Bạn chưa mượn sách này.");
		return "redirect:/";
	}
}
