package UserInterfaceModule;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import CentralizedDataCenter.Entities.Player;
import DynamicObjectModule.DynamicObjectModule;
import RenderEngine.RenderEngine;
import Resources.Resources;
import SceneDataModule.SceneDataModule;

public class GameScene extends JPanel implements KeyListener {
	private Controller controller;
	private Player player;
	private JPanel gamePanel;
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public GameScene(DynamicObjectModule dom,Player player) throws IOException {
		this.setSize(1450, 850);
		this.setLayout(null);
		this.player = player;
		
		
		SceneDataModule sceneDataModule = new SceneDataModule(ImageIO.read(Resources.getResource("Scene/Scene.jpg")));
		RenderEngine renderEngine = new RenderEngine(dom, sceneDataModule);
		gamePanel = renderEngine.getPanel();
		gamePanel.setSize(1450,850);
		add(gamePanel);
		
		renderEngine.startRendering();
		renderEngine.stopRendering();

	}
	
	public void gameStart(){
		this.addKeyListener(this);
		controller = new Controller(this.player);
	}
	
	public void setCountDown(int i){
		JLabel lblWait = new JLabel(i+"");
		lblWait.setBounds((this.getWidth()-100)/2, 20, 100, 30);
		gamePanel.add(lblWait);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		controller.keyPressed(e);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		controller.keyReleased(e);
	}
	

}
