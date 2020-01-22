import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;

abstract public class KCtrl {

	private		Container			con					= null;

	public KCtrl(Container con){

		this.con = con;

	} // end KCtrl

	abstract public void start();

	abstract public void run();

	public Container getParent(){

		return con;

	} // getParent

}
