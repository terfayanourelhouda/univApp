package dz.univbechar.univ.service.controuler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dz.univbechar.univ.service.entity.Students;
import dz.univbechar.univ.service.repository.UnivRepository;

@Controller()
@RequestMapping("/univercity/")
public class Controuler {
	@Autowired
	private UnivRepository repository;
	
	@PutMapping("add")
	public @ResponseBody Object addStd(@RequestBody Students std) {
		repository.save(std);
		return std;
	}
	
	@GetMapping("one")
	public @ResponseBody Object findById( @Param("id") String id) {
		System.out.println("------------------------------------get one in service univercity -------------------------------");
		System.out.println("id = "+ id);
		System.out.println(repository.findById(id).get().toString());
		return  repository.findById(id);
	}
}
