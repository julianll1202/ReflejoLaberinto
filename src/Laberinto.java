public class Laberinto {
    char [][] laberinto;
    int [] ganarPos;
    int [] playerPos;
    char player = '↓';
    int longX;
    int longY;

    public  Laberinto(char[][] laberinto, int [] ganarPos, int [] inicioPos, int longX, int longY){
        this.laberinto = laberinto;
        this.ganarPos = ganarPos;
        this.playerPos = inicioPos;
        this.longX = longX;
        this.longY = longY;
        inicio();
    }

    public boolean posicionGanadora(int x, int y){
        return (x == ganarPos[0] && y == ganarPos[1]);
    }

    private void inicio() {
        laberinto[playerPos[1]][playerPos[0]] = player;
    }

    public void verLaberinto() {
        for(int i = 0; i < longY; i++){
            for(int j = 0; j < longX; j++){
                System.out.print(laberinto[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void avanzar() {
        laberinto[playerPos[1]][playerPos[0]] = ' ';
        switch (player) {
            case '↑':
                if(!hayPared(playerPos[0], playerPos[1]-1))
                    playerPos[1] = playerPos[1] - 1;
                break;
            case '↓':
                if(!hayPared(playerPos[0], playerPos[1]+1))
                    playerPos[1] = playerPos[1] + 1;
                break;
            case '←':
                if(!hayPared(playerPos[0]-1, playerPos[1]))
                    playerPos[0] = playerPos[0] - 1;
                break;
            case '→':
                if(!hayPared(playerPos[0]+1, playerPos[1]))
                    playerPos[0] = playerPos[0] + 1;
                break;
        }
        laberinto[playerPos[1]][playerPos[0]] = player;
    }

    public void girarI() {
        switch(player) {
            case '↑':
                player = '←';
                break;
            case '↓':
                player = '→';
                break;
            case '→':
                player = '↑';
                break;
            case '←':
                player = '↓';
                break;
        }
    }
    public void girarD() {
        switch(player) {
            case '↑':
                player = '→';
                break;
            case '↓':
                player = '←';
                break;
            case '→':
                player = '↓';
                break;
            case '←':
                player = '↑';
                break;
        }
    }

    public boolean hayPared(int x, int y){
        if(laberinto[y][x] == '*')
            return true;
        else
            return false;
    }

    private boolean sensarI() {
        switch(player) {
            case '↑':
                return !hayPared(playerPos[0] -1, playerPos[1]);
            case '↓':
                return !hayPared(playerPos[0] + 1, playerPos[1]);
            case '→':
                return !hayPared(playerPos[0], playerPos[1] - 1);
            case '←':
                return !hayPared(playerPos[0], playerPos[1] + 1);
        }
        return false;
    }
    private boolean sensarC() {
        switch(player) {
            case '↑':
                return !hayPared(playerPos[0], playerPos[1]-1);
            case '↓':
                return !hayPared(playerPos[0], playerPos[1]+1);
            case '→':
                return !hayPared(playerPos[0]+1, playerPos[1]);
            case '←':
                return !hayPared(playerPos[0]-1, playerPos[1]);
        }
        return false;
    }
    private boolean sensarD() {
        switch(player) {
            case '↑':
                return !hayPared(playerPos[0] + 1, playerPos[1]);
            case '↓':
                return !hayPared(playerPos[0] - 1, playerPos[1]);
            case '→':
                return !hayPared(playerPos[0], playerPos[1] + 1);
            case '←':
                return !hayPared(playerPos[0], playerPos[1] - 1);
        }
        return false;
    }
    public void solucionar() {
        do {
            if (sensarI()) {
                girarI();
                avanzar();
            } else if (sensarD()) {
                girarD();
                avanzar();
            } else if (sensarC()) {
                avanzar();
            } else {
                girarI();
                girarI();
                avanzar();
            }
            verLaberinto();
            System.out.println(playerPos[0]+","+playerPos[1]+"-----------------------");
        } while (!posicionGanadora(playerPos[0], playerPos[1]));
    }
}
