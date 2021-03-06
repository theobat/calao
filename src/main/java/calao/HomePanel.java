/***********************************************
This file is part of the Calao project (https://github.com/Neonunux/calao/wiki).

Calao is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Calao is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Calao.  If not, see <http://www.gnu.org/licenses/>.

**********************************************/
package calao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The Class HomePanel.
 *
 * @author Neonunux
 */
public class HomePanel extends JPanel
{
	private static final Logger logger =  LogManager.getLogger(HomePanel.class.getName());
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The app font. */
	Font appFont;
	
	/** The app bundle. */
	private ResourceBundle appBundle;
	
	/** The Main pic. */
	private BufferedImage MainPic = null;
	
	/** The ear train btn. */
	public RoundedButton inlineBtn, rhythmBtn, scoreBtn, statsBtn, lessonsBtn, earTrainBtn;
	
	/** The home buttons. */
	public JPanel homeButtons;
	
	/** The btn width. */
	private int btnWidth = 220;
	
	/** The logo height. */
	private int logoHeight = 160;

	/**
	 * Instantiates a new home panel.
	 *
	 * @param f the f
	 * @param b the b
	 * @param d the d
	 */
	public HomePanel(Font f, ResourceBundle b, Dimension d) 
	{
		appFont = f;
		appBundle = b;
        try 
        {
    		MainPic = ImageIO.read(getClass().getResourceAsStream("accueil.png"));
        }
        catch(Exception e)
        {
            logger.debug("Cannot load logo image");
        }
        btnWidth = 233;
        //logger.debug("Buttons width = "+ btnWidth);
        Color backgroundColor = Color.decode("0xAFC6E9");
		inlineBtn = new RoundedButton("RBL_INLINE", appBundle);
		inlineBtn.setFont(appFont);
		inlineBtn.setBackground(backgroundColor);
		inlineBtn.setPreferredSize(new Dimension(btnWidth, 300));
	    rhythmBtn = new RoundedButton("RBL_RHYTHM", appBundle);
	    rhythmBtn.setFont(appFont);
	    rhythmBtn.setBackground(backgroundColor);
	    rhythmBtn.setPreferredSize(new Dimension(btnWidth, 300));
	    scoreBtn = new RoundedButton("RBL_SCORE", appBundle);
	    scoreBtn.setFont(appFont);
	    scoreBtn.setBackground(backgroundColor);
	    scoreBtn.setPreferredSize(new Dimension(btnWidth, 300));
	    statsBtn = new RoundedButton("RBL_STATS", appBundle);
	    statsBtn.setFont(appFont);
	    statsBtn.setBackground(backgroundColor);
	    statsBtn.setPreferredSize(new Dimension(btnWidth, 300));
	    lessonsBtn = new RoundedButton("RBL_LESSONS", appBundle);
	    lessonsBtn.setFont(appFont);
	    lessonsBtn.setBackground(backgroundColor);
	    lessonsBtn.setPreferredSize(new Dimension(btnWidth, 300));
	    earTrainBtn = new RoundedButton("RBL_EARTRAIN", appBundle);
	    earTrainBtn.setFont(appFont);
	    earTrainBtn.setBackground(backgroundColor);
	    earTrainBtn.setPreferredSize(new Dimension(btnWidth, 300));

	    homeButtons = new JPanel();
	    homeButtons.setLayout(null);
	    homeButtons.setBackground(Color.white);
	    homeButtons.setPreferredSize(new Dimension(d.width, d.height - logoHeight));
	    homeButtons.setBounds(0, logoHeight, d.width, d.height - logoHeight);
	    homeButtons.add(inlineBtn);
	    homeButtons.add(rhythmBtn);
	    homeButtons.add(scoreBtn);
	    homeButtons.add(statsBtn);
	    homeButtons.add(lessonsBtn);
	    homeButtons.add(earTrainBtn);
	    
	    add(homeButtons);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) 
	{
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// logger.debug("[paintComponent] width = "+ this.getWidth());
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());

		btnWidth = 254;
		int prefWidth = 800 ;
		int btnHeight = 163;
		int margin = 10;
		logger.debug("Buttons width = "+ btnWidth);
		g.drawImage(MainPic, (this.getWidth() / 2) - 300, 0, null);
		homeButtons.setBounds(((this.getWidth() - prefWidth) / 2) + margin, logoHeight, prefWidth-(margin*2), margin + btnHeight *2 );

		inlineBtn.setBounds(0, 0, btnWidth, btnHeight);
		rhythmBtn.setBounds(margin + btnWidth, 0, btnWidth, btnHeight);
		scoreBtn.setBounds(margin*2 + (btnWidth * 2), 0, btnWidth, btnHeight);

		statsBtn.setBounds(0, margin + btnHeight, btnWidth, btnHeight);
		lessonsBtn.setBounds(margin + btnWidth, margin + btnHeight, btnWidth, btnHeight);
		earTrainBtn.setBounds(margin*2 + (btnWidth * 2), margin + btnHeight, btnWidth, btnHeight);
	}
}
