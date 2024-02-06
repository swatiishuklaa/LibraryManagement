package com.management.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.management.dao.UserDao;
import com.management.model.Book;
import com.management.services.ApplicationServices;

import java.util.*;

@Controller
public class HomeController {
	
	@Autowired
	private UserDao userDao;

	ApplicationServices service = new ApplicationServices();
	
	@RequestMapping(value = "/")
    public String index() {
        return "index";
    }
	
	@RequestMapping(value = "/addbook")
    public ModelAndView addBook() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addbook");
        return mv;
    }
	
	@PostMapping("/insert")
    public ModelAndView addBookDetails(@Validated Book book) {
        ModelAndView mv = new ModelAndView();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Book> entity = new HttpEntity<Book>(book, headers);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange("http://localhost:8080/books/", HttpMethod.POST, entity, String.class).getBody();

        String url = "http://localhost:8080/books/";
        Book[] books = restTemplate.getForObject(url, Book[].class);
        assert books != null;
        List<Book> bookList = Arrays.asList(books);
        mv.addObject("bookList", bookList);
        mv.setViewName("booklisting");
        return mv;
    }
	
	@RequestMapping(value="/logout",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView logoutWin(HttpServletRequest request , HttpServletResponse response) {
		 ModelAndView mv = new ModelAndView();
	        HttpSession session = request.getSession();
	        session.setAttribute("username", null);
	        mv.setViewName("index");
	        return mv;
	}

	
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView checkUser(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mv = new ModelAndView();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

       String url = "http://localhost:8080/books/"; 
        RestTemplate restTemplate = new RestTemplate();
        Book[] books = restTemplate.getForObject(url, Book[].class);
        assert books != null;
        List<Book> bookList = Arrays.asList(books);
        
        if (service.authenticate(userDao, username, password)) {

            HttpSession session = request.getSession();
            mv.addObject(bookList);
            session.setAttribute("username", username);
            mv.setViewName("booklisting");
        } else {
            mv.setViewName("index");
        }

        return mv;
    }
	
	 @RequestMapping(value = "/bookList")
	    public ModelAndView bookList() {
	        ModelAndView mv = new ModelAndView();
	        String url = "http://localhost:8080/books/"; //this url gives all books
	        RestTemplate restTemplate = new RestTemplate();
	        Book[] books = restTemplate.getForObject(url, Book[].class);
	        assert books != null;
	        List<Book> bookList = Arrays.asList(books);
	        mv.addObject(bookList);
	        mv.setViewName("booklisting");
	        return mv;
	    }

	
	 @PostMapping("/delete/{id}")
	    public String delete(@PathVariable int id) {
	        ModelAndView mv = new ModelAndView();

	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        HttpEntity entity = new HttpEntity(headers);
	        RestTemplate restTemplate = new RestTemplate();
	        restTemplate.exchange("http://localhost:8080/delete/" + id, HttpMethod.POST, entity, String.class).getBody();
	        return "redirect:/bookList";
	    }
	 
	 @RequestMapping("/editview/{id}")
	    public ModelAndView editBookDetails(@PathVariable int id) {
	        ModelAndView mv = new ModelAndView();

	        RestTemplate restTemplate = new RestTemplate();
	        String url = "http://localhost:8080/books/" + id;  //this url gives book by id
	        Book book = restTemplate.getForObject(url, Book.class);
	        mv.addObject("bookObj", book);
	        mv.setViewName("edit-book");
	        return mv;
	    }
	 
	 @PostMapping("/editview/update")
	    public String update(@Validated Book book) {
		 
	        //ModelAndView mv = new ModelAndView();

	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        HttpEntity<Book> entity = new HttpEntity<Book>(book, headers);
	        RestTemplate restTemplate = new RestTemplate();
	        restTemplate.exchange("http://localhost:8080/update/", HttpMethod.POST, entity, String.class).getBody();
	        return "redirect:/bookList";
	    }

}
