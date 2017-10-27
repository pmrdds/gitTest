package gr.boot.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gr.boot.model.DomainObject;
import gr.boot.repository.DomainObjectJpaRepository;

@RestController
@RequestMapping("api/v1/")
public class DomainObjectController {
	
	@Autowired
	private DomainObjectJpaRepository domainObjectServiceJpa;
	

	@RequestMapping(value="domainobjects", method = RequestMethod.GET)
	public List<DomainObject> listDomainObjects() {
		
		return domainObjectServiceJpa.findAll();
	}
	
	@RequestMapping(value="domainobjects/{id}", method = RequestMethod.DELETE)
	public DomainObject deleteDomainObject(@PathVariable int id) {
		DomainObject deleted  = domainObjectServiceJpa.findOne(id);
		domainObjectServiceJpa.delete(id);
		return deleted;
	}
	
	@RequestMapping(value="domainobjects/{id}", method = RequestMethod.GET)
	public DomainObject viewDomainObject(@PathVariable int id) {
		
		return domainObjectServiceJpa.findOne(id);
	}
	
	//with @responseBody annotation spring will convert the incoming Json to a DomainObject object
	@RequestMapping(value="domainobjects/{id}", method = RequestMethod.PUT)
	public DomainObject editDomainObject(@PathVariable int id, @RequestBody DomainObject domainObject) {
	
		return domainObjectServiceJpa.saveAndFlush(domainObject);	
	}
	
	@RequestMapping(value="domainobjects", method = RequestMethod.POST)
	public DomainObject createNewDomainObject(@RequestBody DomainObject domainObject) {
		return domainObjectServiceJpa.saveAndFlush(domainObject);
	}

}
