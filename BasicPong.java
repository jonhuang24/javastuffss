package Pong;

import zen.core.Zen;

public class BasicPong {

	public static void main(String[] args) {

		Zen.create(500,500);

		// initialize ball x and y position
		int ballx = 250;
		int bally = 250;

		//randomize the direction that the ball moves
		int balldx = Zen.getRandomNumber(-8,8);
		int balldy = Zen.getRandomNumber(8,10);

		int px = 250;
		int py = 450;

		int ex = 250;
		int ey = 50;

		while (true) {

			Zen.setBackground("black");

			//draw the ball
			Zen.setColor("red");
			Zen.fillOval(ballx, bally, 20, 20);

			// move the ball
			ballx = ballx + balldx;
			bally = bally + balldy;

			// check for side wall collisions
			if (ballx < 0 || ballx > 480) {

				balldx = -balldx;
			}
			
			//reset the game if the ball gets past a paddle
			if (bally < 0 || bally > 480) {

				ballx = 250;
				bally = 250;
				balldx = Zen.getRandomNumber(-8,8);
				balldy = Zen.getRandomNumber(8,10);
			}


			Zen.setColor("brown");
			Zen.fillRect(px - 50, py-10, 100, 20);

			if(Zen.isKeyPressed("left")) {

				px -= 5;
			}

			if(Zen.isKeyPressed("right")) {

				px += 5;
			}

			// Check if the ball and paddle are touching
			if (Math.abs(ballx - px) < 50 && Math.abs(bally - py) < 30) {
				
				//randomize the x speed of the ball
				balldx = Zen.getRandomNumber(-8,8);
				
				//flip the ball's y direction
				balldy = -balldy;
			}

			Zen.setColor("purple");
			Zen.fillRect(ex - 50, ey - 10, 100, 20);

			// Check if the ball and enemy paddle are touching
			if (Math.abs(ballx - ex) < 50 && Math.abs(bally - ey) < 10) {
				balldy = -balldy;
			}
			
			// Make the enemy paddle move automatically
			if(ex < ballx) {
				ex += 3;
			}
			
			if (ex > ballx) {
				ex -= 3;
			}

			Zen.buffer(40);
		}
	}
}
