package juegos.principal.segundoparcial;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Principal extends ApplicationAdapter implements InputProcessor{
	SpriteBatch batch;
	Stage stage;
	Texture img;
	int frame;
	Music musica;
	Personaje per;
	GameOver go;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		stage = new Stage();
		per = new Personaje();
		
		stage.addActor(new Plataforma());
		stage.addActor(per);
		Gdx.input.setInputProcessor(this);
		musica = Gdx.audio.newMusic(Gdx.files.internal("audioJuego.mp3"));
	}
	
	void agregarEnemigo(){
		Enemigo ene = new Enemigo(per);
		stage.addActor(ene);
		ene.setX(450);
		
		Enemigo2 ene2 = new Enemigo2(per);
		stage.addActor(ene2);
		ene.setX(250);
	}
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 1, 5, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.draw();
		stage.act();
		musica.play();
		
		if(frame%200==0)
			agregarEnemigo();
			
		frame++;
						
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		per.saltar();
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
