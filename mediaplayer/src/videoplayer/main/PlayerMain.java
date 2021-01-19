package videoplayer.main;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import videoplayer.views.MainWindow;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.SwingWorker;

import com.sun.jna.NativeLibrary;

public class PlayerMain {
	
	static MainWindow frame;

    private static final String NATIVE_LIBRARY_SEARCH_PATH = "D:/ÃÙ’Ω±≠/VideoLAN/VLC";

    public static void main(String[] args) {
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), NATIVE_LIBRARY_SEARCH_PATH);
        System.out.println(LibVlc.INSTANCE.libvlc_get_version());
        
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainWindow();
					frame.setVisible(true);
					String options[] = {"- -subsdec-encoding=GB18030"};
//					frame.getMediaPlayer().playMedia("E:\\BaiduYunDownload\\late in autumn.flv");
					frame.getMediaPlayer().prepareMedia("E:\\BaiduYunDownload\\late in autumn.flv");
					new SwingWorker<String, Integer>(){

						@Override
						protected String doInBackground() throws Exception {
							while (true) {
								long total = frame.getMediaPlayer().getLength();
								long current = frame.getMediaPlayer().getTime();
								float percent = (float) current / total;
								publish((int) (percent*100));
								Thread.sleep(100);
							}
						}
						protected void process(java.util.List<Integer> chunks) {
							for (int v : chunks){
								frame.getProgressBar().setValue(v);
							}
						};
					}.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
    
    public static void play() {
		frame.getMediaPlayer().play();
	}
    public static void pause() {
    	frame.getMediaPlayer().pause();
	}
    public static void stop() {
    	frame.getMediaPlayer().stop();
    }
    public static void jumpTo(float to) {
		frame.getMediaPlayer().setTime((long)(to*frame.getMediaPlayer().getLength()));
	}
    public static void openVideo() {
		JFileChooser chooser = new JFileChooser();
		int v = chooser.showOpenDialog(null);
		if(v == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			frame.getMediaPlayer().playMedia(file.getAbsolutePath());
		}
	}
    public static void openSubtitle() {
    	JFileChooser chooser = new JFileChooser();
		int v = chooser.showOpenDialog(null);
		if(v == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			frame.getMediaPlayer().setSubTitleFile(file);
		}
	}
    public static void exit() {
		frame.getMediaPlayer().release();
		System.exit(0);
	}
    public static void setVol(int v) {
		frame.getMediaPlayer().setVolume(v);
	}
}