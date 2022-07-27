package service;

import java.util.Date;
import java.util.List;

import dao.NoteDAO;
import model.Note;

public class NoteService {
	private NoteDAO noteDAO;

	public NoteService(NoteDAO noteDAO) {
		this.noteDAO = noteDAO;
	}

	public List<Note> getAllNote() {
		return noteDAO.getNoteAll(null);
	}

	public List<Note> getNote(String name, String message) {
		Note condition = new Note();
		condition.setName(name);
		condition.setMessage(message);

		return noteDAO.getNoteAll(condition);
	}

	public void addNote(String name, String message, Date dateNoti) throws Exception {
		Note condition = new Note();
		condition.setName(name);
		condition.setMessage(message);
		condition.setDateNoti(dateNoti);
		condition.setCreateDate(new Date());
		condition.setSendNoti(true);

		int status = noteDAO.insert(condition);

		if (status != 1) {
			throw new Exception("check sql insert");
		}
	}

	public void updateNote(String name, String message, Date dateNoti, boolean sendNoti, int id) throws Exception {
		Note condition = new Note();
		condition.setName(name);
		condition.setMessage(message);
		condition.setDateNoti(dateNoti);
		condition.setUpdateDate(new Date());
		condition.setSendNoti(sendNoti);

		int status = noteDAO.update(condition, id);

		if (status != 1) {
			throw new Exception("check sql update");
		}

	}
	
	public List<Note> getNoteLike(String name, String message) {
		Note condition = new Note();
		condition.setName(name);
		condition.setMessage(message);

		return noteDAO.getNoteLikeByNameAndMessage(condition);
	}
	

}
