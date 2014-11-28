package juegos.principal.segundoparcial;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Personaje extends Actor{

	ArrayList<Image>images;
	int dibujo_actual = 0;
	float tiempo_act = 0;
	float velocidad_y=0;
	float aceleracion_y=0.01f;
	
	public Personaje(){
		super();
		images = new ArrayList<Image>();
		images.add(new Image(new Texture("run01.png")));
		images.add(new Image(new Texture("run02.png")));
		images.add(new Image(new Texture("run03.png")));
		images.add(new Image(new Texture("run04.png")));
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
		
		velocidad_y+=aceleracion_y;
		this.setY(this.getY()+velocidad_y);
		
		if(this.getY()<=50){
			velocidad_y = 0;
			aceleracion_y = 0;
			this.setY(50);
		}
		
		//Desplazamiento en Y
		velocidad_y+=aceleracion_y;
		this.setY(this.getY()+velocidad_y);
		
		//Gravedad
		aceleracion_y-=0.25;
		
//		this.setX(this.getX()+3);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		images.get(dibujo_actual).setY(50);
		images.get(dibujo_actual).setY(this.getY());
		super.draw(batch, parentAlpha);
		images.get(dibujo_actual).setX(this.getX());
		images.get(dibujo_actual).draw(batch, parentAlpha);
	}
	
	void saltar(){
		System.out.println("Salto");
		aceleracion_y=2;
	}
	
}
