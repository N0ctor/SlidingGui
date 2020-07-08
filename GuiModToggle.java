package clientname.gui.options
;

import java.awt.Button;
import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;

import clientname.Utils.Colorutils;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class GuiModToggle extends GuiScreen {
	
	
	private int fadeIn;
	private boolean fadingOut;
	private int fadeOut;
	
	
	private static final Color s1_color = Color.BLACK;
	private static final String s1 = "Keystokes";
	private static final int keywidth = 64;
	
	
	int index = 0;
	long x = 0; 
	
	

	private ScrollListModToggle scrollPanel;

	@Override
	public void initGui() {
		this.fadeIn = 0;
		this.fadingOut = false;
		this.fadeOut = 0;
		mc.gameSettings.CLIENT_TOGGLEMOD.isKeyDown();
		scrollPanel = new ScrollListModToggle(mc, this);	
		this.buttonList.clear();
		
	}
	
	@Override
	public void updateScreen() {
if(fadeIn < 100) {
		fadeIn++;
	}
	
	
	
	
	if(fadingOut) {
		if(fadeOut < 100) {
		fadeOut++;	
		}
		
		
		
	}
	
	if(fadeOut >= 99){
	this.mc.setIngameFocus();
	this.mc.displayGuiScreen((GuiScreen)null);
		
	}
	}

	@Override
	public void handleMouseInput() throws IOException {
		super.handleMouseInput();
		this.scrollPanel.handleMouseInput();
	}

	@Override
protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		this.scrollPanel.mouseClicked(mouseX, mouseY, mouseButton);
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		this.scrollPanel.mouseReleased(mouseX, mouseY, state);
		super.mouseReleased(mouseX, mouseY, state);
	}
	
	

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		// ScaledResolution scaledRes = new ScaledResolution(this.mc);
		  super.drawScreen(mouseX, mouseY, partialTicks);
		  updateScreen();
		  
		  GuiScreen.drawRect(0, 0, 0 + fadeIn - fadeOut, this.height, Colorutils.rainbowEffect(index + x*20000000F, 1.0F).getRGB());
		 // GuiButton.drawRect(left, top, right, bottom, color);
		  this.scrollPanel.setDimensions(fadeIn * 3, this.height, fadeOut * 3, this.height);
		  //this.scrollPanel.setDimensions(widthIn, heightIn, topIn, bottomIn);
			//this.drawRect(0, 65, 90 , 16, new Color(255, 255, 255).getRGB());
			//this.drawString(fontRendererObj, s1, 15, 15, -1);
			
			//this.buttonList.add(new GuiButton(191, 15, 15, "Keystokes"));
		  
		 // GuiCheckBox.drawRect(0, 65, 90, 16, new Color(0, 0, 0).getRGB());
		  
			
			
 //this.drawRect(left, top, right, bottom, color);
			
			
	this.scrollPanel.drawScreen(mouseX, mouseY, partialTicks);
		//this.drawCenteredString(this.fontRendererObj, "Mod Options", this.width / 2, 8, 16777215);
			
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
	if(keyCode == Keyboard.KEY_ESCAPE) {
		fadingOut = true;
	}
	
	
	}
	

}