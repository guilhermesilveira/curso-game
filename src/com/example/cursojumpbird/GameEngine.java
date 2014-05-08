class GameEngine {
private Entidade[] elementos;
  GameEngine(ScreenHelper sh) {
    Bird bird = new Bird(screenhelper);
    Pipes pipes = new Bird(screenhelper);
    Background bg = new Background(screenhlper e o que faltar - ou ja recebe aqui o bitmap);
    this.elementos = new Entidade[]{bird, pipes, bg};
  }
  
  void novoRound(canvas) {
    for(Entidade e : elementos) e.drawOn(canvas)
			bird.cai();
  }
  // da para fazer de outr amaneira, mas deixei aqui
  void pula() {
    bird.pula();
  }
}

