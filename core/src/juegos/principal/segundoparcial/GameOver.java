package juegos.principal.segundoparcial;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class GameOver extends Image{

	GameOver(){
		super(new Texture("GameOver.png"));
		this.setX(1);
		this.setY(1);
	}
	
	public void act(float delta){
		super.act(delta);
		this.setX(this.getX());
	}

}
