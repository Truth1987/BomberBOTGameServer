package ObjectStructure;

import java.io.BufferedWriter;
import java.io.IOException;

import SocketServer.Option;
import Tool.ST;

public class Player{
	private String ID;
	private int Score;
	private String Password;
	private int Wins;
	private int Losses;
	private int Tie;

	private transient BufferedWriter Writer;
	private transient Message message;
	private transient State Status;
	private transient boolean Live;
	
	public boolean isLive() {
		return Live;
	}

	public void setLive(boolean inputLive) {
		Live = inputLive;
	}

	public Player(){
		ID = null;
		Score = Option.InitScore;
		Password = null;
		Wins = 0;
		Losses = 0;
		Tie = 0;
		message = null;
		Status = new State();
	}
	
	public int getTie() {
		return Tie;
	}

	public void setTie(int inputTie) {
		Tie = inputTie;
	}

	public String getState(){
		return Status.toString();
	}
	public void setState(String inputState){
		Status.setStatus(inputState);
	}
	
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	public void setWriter(BufferedWriter inputWriter) {
		Writer = inputWriter;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public String getPassWord() {
		return Password;
	}
	public void setPassWord(String passWord) {
		Password = passWord;
	}
	public int getWins() {
		return Wins;
	}
	public void setWins(int wins) {
		Wins = wins;
	}
	public int getLosses() {
		return Losses;
	}
	public void setLosses(int losses) {
		Losses = losses;
	}
	public boolean sendMsg(Message inputMsg){
		
		String Msg = ST.MessageToString(inputMsg);
		try {
			Writer.write(Msg + "\r\n");
			Writer.flush();
			Writer.close();
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
	
	public void setMessage(Message inputMessage) {
		if(message == null){
			message = inputMessage;
		}
	}

	public Message getMessage() {
		Message temp = message;
		
		message = null;
		
		return temp;
	}
}
