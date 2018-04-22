package com.example.springbootdemo.controller;

import com.example.springbootdemo.pojo.BookInfo;
import com.example.springbootdemo.pojo.DemoEntity;
import com.example.springbootdemo.pojo.Users;
import com.example.springbootdemo.service.BookInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//@RestController的意思就是controller里面的方法都以json格式输出
@Controller
@RequestMapping("/demo")
@EnableAutoConfiguration
public class DemoController {

	private Logger logger = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Resource(name = "bookInfoService")
	BookInfoService bookInfoService;

	@RequestMapping(value="/findAll", method = RequestMethod.GET)
    public String findAll(Model model) {
        List<BookInfo> bookInfos = bookInfoService.findAll(null, null, null, 0, 100);
        model.addAttribute("list", bookInfos);
        model.addAttribute("msg", "hello Thymeleaf");
        return "list";
    }

	@RequestMapping("/login")
	public Object login(Model model, @RequestParam String code, @RequestParam String pwd, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {
		Users u = bookInfoService.findByUser(code, pwd);
		if (u != null) {
			Integer count = bookInfoService.findCount(null, null, null);
			int allpage = count % 5 == 0 ? count / 5 : count / 5 + 1;
			session.setAttribute("user", u);
			model.addAttribute("list", bookInfoService.findAll(null, null, null, 0, 5));
			model.addAttribute("count", bookInfoService.findCount(null, null, null));
			model.addAttribute("allpage", allpage);
			model.addAttribute("pageNo", 1);
			List<BookInfo> bookInfos = bookInfoService.findAll(null, null, null, 0, 100);
//			return "list";
			return bookInfos;
		} else {
			session.setAttribute("msg", "账号或密码错误！");
//			return "redirect:/index.jsp";
			return "账号或密码错误！";
		}
	}

	@RequestMapping("/del")
	public String del(Model model, @RequestParam(value = "id") Integer id) {

		int rst = bookInfoService.delById(id);
		if (rst > 0) {
			model.addAttribute("msg", "删除成功");
			return "删除成功";
		} else {
			model.addAttribute("msg", "删除失败");
			return "删除失败";
		}
		//return "redirect:/stand/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Model model, BookInfo bookInfo) {
		if (bookInfoService.add(bookInfo) > 0) {
			model.addAttribute("msg", "添加成功");
			return "添加成功";
//			return "redirect:/stand/list";
		} else {
			model.addAttribute("msg", "添加失败");
//			return "redirect:/stand/list";
			return "添加失败";
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Model model, BookInfo bookInfo) {
		if (bookInfoService.add(bookInfo) > 0) {
			model.addAttribute("msg", "修改成功");
			return "修改成功";
//			return "redirect:/stand/list";
		} else {
			model.addAttribute("msg", "修改失败");
			return "修改成功";
//			return "redirect:/stand/list";
		}

	}

	// -------------------------------------------------------------

	@RequestMapping("/test")
	Object test() {
		DemoEntity entity = new DemoEntity();
		entity.setId("1");
		entity.setUsername("周宇峰");
		entity.setPassword("123456");
		logger.debug("这是debug信息");
		logger.info("这是info信息");
		logger.warn("这是warn信息");
		logger.error("这是error信息");
		return entity;
	}

	@RequestMapping("/list")
	public List<Map<String, Object>> list() {
		String sql = "select * from book_info";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> map : list) {
			Set<Entry<String, Object>> entries = map.entrySet();
			if (entries != null) {
				Iterator<Entry<String, Object>> iterator = entries.iterator();
				while (iterator.hasNext()) {
					Entry<String, Object> entry = (Entry<String, Object>) iterator.next();
					Object key = entry.getKey();
					Object value = entry.getValue();
					System.out.println(key + ":" + value);
				}
			}
		}
		return list;
	}

	@RequestMapping("/findById/{id}")
	public Map<String, Object> findById(@PathVariable String id) {
		Map<String, Object> map = null;

		List<Map<String, Object>> list = list();

		for (Map<String, Object> dbmap : list) {

			Set<String> set = dbmap.keySet();

			for (String key : set) {
				if (key.equals("id")) {
					if (dbmap.get(key).equals(id)) {
						map = dbmap;
					}
				}
			}
		}

		if (map == null)
			map = list.get(0);
		return map;
	}

}
