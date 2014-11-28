package juegos.principal.segundoparcial;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Enemigo extends Image {

	ArrayList<Image>images;
	int dibujo_actual = 0;
	float tiempo_act = 0;
	Personaje p;

	public Enemigo(Personaje p){
		super();
		this.p=p;
		images = new ArrayList<Image>();
		images.add(new Image(new Texture("sola1.png")));
		images.add(new Image(new Texture("sola2.png")));
		images.add(new Image(new Texture("sola4.png")));
		images.add(new Image(new Texture("sola5.png")));
		images.add(new Image(new Texture("sola1.png")));
		images.add(new Image(new Texture("sola4.png")));
		images.add(new Image(new Texture("sola2.png")));
		images.add(new Image(new Texture("sola5.png")));
		this.setY(100);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		tiempo_act+= delta;
				
		if(tiempo_act>0.1f){
			dibujo_actual++;
			tiempo_act = 0;
		}
		if(dibujo_actual >= images.size()){
			dibujo_actual = 0;
		}
		this.setX(this.getX()-3);
		
		//choque de imagenes
		Rectangle r1=new Rectangle(this.getX(), this.getY(), 100, 100);
		Rectangle r2=new Rectangle(p.getX(), p.getY(), 100, 100);
		if(r1.overlaps(r2)){
			System.out.println("Colision!");
			System.out.println("Perdiste");
			images.add(new Image(new Texture("GameOver.png")));
		}
			
//		if(this.getX()<p.getX()+50
//				&& this.getX()+50>p.getX()
//				&& this.getY()<p.getY()+50
//				&& this.getY()+50>p.getY())
//			System.out.println("Colision!");
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
		images.get(dibujo_actual).setX(450);
		images.get(dibujo_actual).setY(this.getY());
		images.get(dibujo_actual).setX(this.getX());
		images.get(dibujo_actual).draw(batch, parentAlpha);
	}
}
