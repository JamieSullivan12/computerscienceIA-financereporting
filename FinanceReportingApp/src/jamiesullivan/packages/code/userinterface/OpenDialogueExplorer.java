package jamiesullivan.packages.code.userinterface;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class OpenDialogueExplorer {
	public static String initialiseExplorer(String directory, String title, boolean showDirectories, boolean showFiles ) throws Exception {
		
		
		JButton open = new JButton();
	    JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File(directory));
	    chooser.setDialogTitle(title);
	    if (showDirectories && showFiles) {
	    	chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	    } else if (showDirectories && !showFiles) {
	    	chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    } else if (!showDirectories && showFiles) {
	    	chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    }
	    
	    if (chooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {

	    	try {
	    		return chooser.getSelectedFile().getAbsolutePath();
			} catch (Exception e) {
				return null;
			}
	    } else {
    		return null;
    	}
	}
}
