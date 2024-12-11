package org.jsp.event.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.event.entity.Event;
import org.jsp.event.entity.EventStatus;
import org.jsp.event.repository.EventRepository;
import org.jsp.event.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/events")
public class EventController {
	@Autowired
	EventRepository eventRepository;

	@PostMapping
	public ResponseStructure<Event> saveEvent(@RequestBody Event event) {
		event = eventRepository.save(event);
		ResponseStructure<Event> res = new ResponseStructure<>();
		res.setHttpStatus(200);
		res.setMessage("Event Saved Sucsessfully");
		res.setBody(event);
		return res;
	}

	@PutMapping
	public Event updateEvent(@RequestBody Event event) {
		return eventRepository.save(event);
	}

	@GetMapping
	public ResponseStructure<List<Event>> findAll() {
		List<Event> el = eventRepository.findAll();
		ResponseStructure<List<Event>> structure = new ResponseStructure<>();
		if (el.isEmpty()) {
			structure.setHttpStatus(404);
			structure.setMessage("No Events Found In The Database");
			structure.setBody(el);
			return structure;
		}
		structure.setHttpStatus(200);
		structure.setMessage("All Events Found Sucsess fully");
		structure.setBody(el);
		return structure;
	}

	@GetMapping("/{id}")
	public ResponseStructure<Event> getById(@PathVariable int id) {
		Optional<Event> op = eventRepository.findById(id);
		ResponseStructure<Event> res = new ResponseStructure<>();
		if (op.isEmpty()) {
			res.setHttpStatus(404);
			res.setMessage("Invalid Event Id");
			res.setBody(null);
			return res;
		}
		res.setHttpStatus(200);
		res.setMessage("Event Found Sucsessfully");
		res.setBody(op.get());
		return res;
	}

	@DeleteMapping("/{id}")
	public String delById(@PathVariable int id) {
		Optional<Event> op = eventRepository.findById(id);
		if (op.isEmpty())
			return "Ivalid Id ........ Unable to delete";
		eventRepository.deleteById(id);
		return "Deleted Sucessfully";
	}

	@GetMapping("/guest/{guest}")
	public List<Event> findByGuest(@PathVariable String guest) {

		return eventRepository.findByGuest(guest);
	}

	@GetMapping("/title/{title}")
	public List<Event> getByTitle(@PathVariable String title) {
		return eventRepository.findByTitle(title);
	}

	@GetMapping("/status/{status}")
	List<Event> getByStatus(String status)// Not Working
	{

		if (EventStatus.COMPLETED.toString().equalsIgnoreCase(status)) {

			return eventRepository.findByStatus(EventStatus.COMPLETED);
		} else if (EventStatus.ON_GOING.toString().equalsIgnoreCase(status)) {

			return eventRepository.findByStatus(EventStatus.ON_GOING);
		} else if (EventStatus.UP_COMING.toString().equalsIgnoreCase(status)) {

			return eventRepository.findByStatus(EventStatus.UP_COMING);
		}
		return null;

	}
}
