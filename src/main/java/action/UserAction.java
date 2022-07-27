package action;

import javax.faces.event.ActionEvent;

public interface UserAction 
{
	public void onClickSearch(ActionEvent event);
	public void onClickSubmitAdd(ActionEvent event);
	public void onClickSubmitUpdate(ActionEvent event);
	public void onClickBtnAdd(ActionEvent event);
	public void onClickBtnEdit(ActionEvent event);
	public void onClickBtnDelete(ActionEvent event);
}
