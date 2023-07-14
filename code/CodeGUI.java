// UNCOMPLETED!!!!!
import javax.swing.*;
import javax.swing.plaf.TabbedPaneUI;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.List;
import java.util.*;

public class CodeGUI{
	
	public static final CodeGUI INSTANCE = new CodeGUI();
	private static int boardSize;
	private final JFrame mainFrame = new JFrame();
	private final JPanel morsePanel = new JPanel(new GridLayout());
	private final JPanel caesarPanel = new JPanel();
	private final JPanel fencePanel = new JPanel();
	private final JPanel vigenerePanel = new JPanel();
	private final List<JPanel> panels = new ArrayList<>();
	JTabbedPane tabbedPane = new JTabbedPane();
	{
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("CodeGUI");
		mainFrame.setSize(500, 500);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
	}
	
	{
		boardSize = (int)(mainFrame.getWidth() * 0.05);
	}
	
	{
		morsePanel.setLayout(null);
		caesarPanel.setLayout(null);
		fencePanel.setLayout(null);
		vigenerePanel.setLayout(null);
	}
	
	{
		mainFrame.add(tabbedPane);
		panels.add(morsePanel);
		panels.add(caesarPanel);
		panels.add(fencePanel);
		panels.add(vigenerePanel);
		tabbedPane.addTab("MorseCode", morsePanel);
		tabbedPane.addTab("CaesarCode", caesarPanel);
		tabbedPane.addTab("FenceCode", fencePanel);
		tabbedPane.addTab("VigenereCode", vigenerePanel);
		for(JPanel panel : panels){
			for(Component p : getDefaultElements()){
				panel.add(p);
			}
		}
		mainFrame.repaint();
	}
	private static final Map<String, Class> classes = new HashMap<>();
	static {
		classes.put("MorseCode", MorseCode.class);
		classes.put("CaesarCode", CaesarCode.class);
		classes.put("FenceCode", FenceCode.class);
		classes.put("VigenereCode", VigenereCode.class);
	}
	private static final Map<String, Method> methods = new HashMap<>();
	/*static{
		methods.put("MorseCode")
		methods.put("MorseCode")
		methods.put("CaesarCode")
		methods.put("CaesarCode")
		methods.put("")
		methods.put("")
		methods.put("")
		methods.put("")
	}*/
	public static void main(String[] args){
		JPanel mainPanel;
		MyTextField decode = new MyTextField();
		MyTextField encode = new MyTextField();
		MyTextField dit_morse = new MyTextField();
		MyTextField dah_morse = new MyTextField();
		MyTextField spilt_morse = new MyTextField();
		MyTextField offset_caesar = new MyTextField();
		MyTextField column_fence = new MyTextField();
		MyTextField offset_vigenere = new MyTextField();
		while(true){
			int index = INSTANCE.tabbedPane.getSelectedIndex();
			mainPanel = INSTANCE.panels.get(index);
			for(Component c : mainPanel.getComponents()){
				if(c instanceof MyTextField mtf){
					switch(mtf.getName()){
						case "decode" -> decode = mtf;
						case "encode" -> encode = mtf;
					}
				}
			}
			Component c = INSTANCE.mainFrame.getFocusOwner();
			Class targetClass = MorseCode.class;
			if (c instanceof JTabbedPane jtp){
				try{
					targetClass = Class.forName(jtp.getTitleAt(jtp.getSelectedIndex()));
				}catch(ClassNotFoundException e){
					e.printStackTrace();
				}
			}
			if(c instanceof MyTextField mtf){
			String s = mtf.getText();
				switch (mtf.getName()) {
//					case "decode" -> encode.setText();
//					case "encode" -> decode.setText();
				}
			}
		}
	}
	
	private List<Component> getDefaultElements(){
		List<Component> defaultElements = new ArrayList<>();
		Component p = new JTextArea("Decoded");
		p.setBounds(boardSize, boardSize, (mainFrame.getWidth() - 2 * boardSize) / 3,
		            (int)(mainFrame.getHeight() * 0.05));
		p.setFocusable(false);
		defaultElements.add(p);
		p = new MyTextField();
		p.setName("decode");
		p.setBounds(boardSize, boardSize * 2 + (int)(mainFrame.getHeight() * 0.05),
		            (mainFrame.getWidth() - 3 * boardSize), (int)(mainFrame.getHeight() * 0.05));
		defaultElements.add(p);
		p = new JTextArea("Encoded");
		p.setBounds(boardSize, boardSize * 3 + (int)(mainFrame.getHeight() * 0.05) * 2,
		            (mainFrame.getWidth() - 2 * boardSize) / 3, (int)(mainFrame.getHeight() * 0.05));
		defaultElements.add(p);
		p.setFocusable(false);
		p = new MyTextField();
		p.setName("encode");
		p.setBounds(boardSize, boardSize * 4 + (int)(mainFrame.getHeight() * 0.05) * 3,
		            (mainFrame.getWidth() - 3 * boardSize), (int)(mainFrame.getHeight() * 0.05));
		defaultElements.add(p);
		return defaultElements;
	}
	
	private static class MyTextField extends JTextField{
		
		private Class<Object> codeClass = Object.class;
		private String name = "";
		
		public MyTextField(String text){
			super(text);
		}
		
		public MyTextField(){
			super();
		}
		
		public String getName(){
			return name;
		}
		
		public void setName(String name){
			this.name = name;
		}
		
		public Class getCodeClass(){
			return codeClass;
		}
		
		public void setCodeClass(Class codeClass){
			this.codeClass = codeClass;
		}
	}
}
