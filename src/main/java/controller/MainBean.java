package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import action.UserAction;
import dao.NoteDAO;
import model.Note;
import service.NoteService;

public class MainBean  implements Serializable , UserAction
{

	private static final long serialVersionUID = 1L;
	
	
	 
	public List<Note> listOfNote;
	public Note objConditionSearch;
	public Note objReferenceDataBase;
	public NoteService noteService = new NoteService(new NoteDAO());
	
	public MainBean()
	{
		this.listOfNote = new ArrayList<Note>();
		this.objConditionSearch = new Note();
		this.objReferenceDataBase = new Note();
		
		init();
	}
	
	public void init()
	{
	    List<Note> resultNote = noteService.getAllNote();
		
		setListOfNote(resultNote);
	}

	public List<Note> getListOfNote() {
		return listOfNote;
	}



	public Note getObjConditionSearch() {
		return objConditionSearch;
	}



	public void setObjConditionSearch(Note objConditionSearch) {
		this.objConditionSearch = objConditionSearch;
	}



	public Note getObjReferenceDataBase() {
		return objReferenceDataBase;
	}



	public void setObjReferenceDataBase(Note objReferenceDataBase) {
		this.objReferenceDataBase = objReferenceDataBase;
	}



	public void setListOfNote(List<Note> listOfNote) {
		this.listOfNote = listOfNote;
	}

	
	public void onChangeInputSearch(AjaxBehaviorEvent event)
	{
		List<Note> resultNote = noteService.getNoteLike(objConditionSearch.getName(), objConditionSearch.getMessage());
		
		setListOfNote(resultNote);
	}

	@Override
	public void onClickSearch(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClickSubmitAdd(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClickSubmitUpdate(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClickBtnAdd(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClickBtnEdit(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClickBtnDelete(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
	
 
 
	
	
}
