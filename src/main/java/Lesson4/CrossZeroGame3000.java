package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class CrossZeroGame3000 {
    public  static final int GAME_DESK_SIZE = 5;
    public  static final int GAME_WIN_CONDITION = 4;
    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';
    public static final char DOT_EMPTY = '-';
    public static final char DOT_AIPOINT = '^';
    public static final Scanner SKANNER = new Scanner(System.in);
    public static Random rand = new Random();

    public static class GameMap {
        private static char[][] gameDesk;
        private static int deskSize;
        private static int winCondition;
        private static int countX;
        private static int count0;

        /**
         * Инициализация игровой доски с указанием размерности игрового поля
         * @param gameDeskSize
         */
        GameMap (int gameDeskSize, int gameWinCondition) {
            deskSize = gameDeskSize;
            winCondition = gameWinCondition;
            gameDesk = new char[deskSize][deskSize];
            for (int x = 0; x < deskSize; x++) {
                for (int y = 0; y < deskSize; y++) {
                    gameDesk[x][y] = DOT_EMPTY;
                }
            }
            paintDesk();
        }

        private static void setCountXand0 (int cX, int c0) {
            countX = cX;
            count0 = c0;
        }

        private static int getCountDotsEmpty () {
            int result = 0;
            for (int i = 0; i < deskSize; i++) {
                for (int j = 0; j < deskSize; j++) {
                    if (gameDesk[i][j] != DOT_EMPTY) continue;
                    result++;
                }
            }
            return result;
        }

        /**
         * Рисуем актуальную доску
         */
        public static void paintDesk () {
            for (int x = 0; x <= deskSize; x++) {
                System.out.print(x + " ");
            }
            System.out.println();
            for (int x = 0; x < deskSize; x++) {
                System.out.print(x + 1 + " ");
                for (int y = 0; y < deskSize; y++) {
                    System.out.print(gameDesk[x][y] + " ");
                }
                System.out.println();
            }
        }

        /**
         * Проверяем ход на корректность. На входе координаты x, y
         * @param x
         * @param y
         * @return
         */
        public static boolean isTurnValid(int x, int y) {
            if (x < 0 || x >= deskSize || y < 0 || y >= deskSize) {
                return false;
            }
            return (gameDesk[x][y] == DOT_EMPTY);
        }

        /**
         * Игрок совершает ход
         * @param x
         * @param y
         * @return
         */
        public static boolean humanTurn (int x, int y) {
            if (!isTurnValid(x, y)) {
                return false;
            }
            gameDesk[x][y] = DOT_X;
            return true;
        }

        /**
         * Компьютер совершает ход
         * @return
         */
        public static void aiTurn () {
            int winX = -1, winY = -1, loseX = -1, loseY = -1;
            for (int i = 0; i < deskSize; i++) {
                for (int j = 0; j < deskSize; j++) {
                    if (gameDesk[i][j] != DOT_EMPTY) continue;
                    gameDesk[i][j] = DOT_AIPOINT;
                    switch (checkGameDeskRowsColumns(true)) {
                        case 1:
                            loseX = i; loseY = j;
                            break;
                        case 2:
                            winX = i; winY = j;
                            break;
                    }
                    switch (checkGameDeskRowsColumns(false)) {
                        case 1:
                            loseX = i; loseY = j;
                            break;
                        case 2:
                            winX = i; winY = j;
                            break;
                    }
                    switch (checkGameDeskDiagonals(true)) {
                        case 1:
                            loseX = i; loseY = j;
                            break;
                        case 2:
                            winX = i; winY = j;
                            break;
                    }
                    switch (checkGameDeskDiagonals(false)) {
                        case 1:
                            loseX = i; loseY = j;
                            break;
                        case 2:
                            winX = i; winY = j;
                            break;
                    }
                    gameDesk[i][j] = DOT_EMPTY;
                }
            }
            if (winX >= 0) gameDesk[winX][winY] = DOT_0; //Проверка, может ли ИИ победить в следующем ходу, если да, тогда делаем победный ход
            else if (loseX >= 0) gameDesk[loseX][loseY] = DOT_0; //Проверка, может ли ИИ проиграть в следующем ходу, если да, тогда постараемся избежать этого
            int massSize = getCountDotsEmpty();
            if (massSize == 0) return;
            int[] massX = new int[massSize];
            int[] massY = new int[massSize];
            int k = 0;
            for (int i = 0; i < deskSize; i++) {
                for (int j = 0; j < deskSize; j++) {
                    if (gameDesk[i][j] != DOT_EMPTY) continue;
                    massX[k] = i;
                    massY[k] = j;
                    k++;
                }
            }
            int nextstep = rand.nextInt(massSize);
            gameDesk[massX[nextstep]][massY[nextstep]] = DOT_0;
        }

        /**
         * Проверка заполненности доски
         * @return
         */
        private static boolean isGameDeskFull() {
            for (int i = 0; i < deskSize; i++) {
                for (int j = 0; j < deskSize; j++) {
                    if (gameDesk[i][j] == DOT_EMPTY) {
                        return false;
                    }
                }
            }
            return true;
        }

        /**
         * Проверка победы одного из игроков.
         * @param ifRow Если true тогда проверка по строкам, если false то проверка по столбцам
         * @return 0 - нет победы, 1 - победа игрока X, 2 - победа игрока 0
         */
        private static byte checkGameDeskRowsColumns(boolean ifRow) {
            byte result = 0;
            int a, b;
            for (int i = 0; i < deskSize; i++) {
                if (result != 0) break;
                setCountXand0(0,0);
                for (int j = 0; j  < deskSize; j++) {
                    if (ifRow) {
                        a = i;
                        b = j;
                    } else {
                        a = j;
                        b = i;
                    }
                    switch (gameDesk[a][b]) { //Подсчитываем количество подряд идущих одинаковых символов
                        case DOT_X:
                            setCountXand0(++countX, 0);
                            break;
                        case DOT_0:
                            setCountXand0(0, ++count0);
                            break;
                        case DOT_EMPTY:
                            setCountXand0(0,0);
                            break;
                        case DOT_AIPOINT: //Для ИИ
                            setCountXand0(++countX, ++count0);
                    }
                    if (result != 0) break;
                    else if (countX == winCondition) { //Если количество иксов равно условию победы
                        result = 1; //Значит победил игрок X
                    } else if (count0 == winCondition) result = 2; //Тоже самое для нуликов
                }
            }
            return result;
        }

        /**
         * Проверка победы одного из игроков.
         * @param ifFirst Если true тогда проверка первой диагонали, если false то проверка второй диагонали
         * @return 0 - нет победы, 1 - победа игрока X, 2 - победа игрока 0
         */
        private static byte checkGameDeskDiagonals(boolean ifFirst) {
            byte result = 0;
            setCountXand0(0,0);
            for (int i = 0; i < deskSize; i++) {
                if (result != 0) break;//если ответ не нуль, значит кто-то победил, прервем цикл
                for (int j = 0; j < deskSize; j++) {
                    if ((ifFirst && i == j) || (!ifFirst && i == deskSize - j - 1)) {
                        switch (gameDesk[i][j]) {
                            case DOT_X:
                                setCountXand0(++countX, 0);
                                break;
                            case DOT_0:
                                setCountXand0(0, ++count0);
                                break;
                            case DOT_EMPTY:
                                setCountXand0(0, 0);
                                break;
                            case DOT_AIPOINT: //Для ИИ
                                setCountXand0(++countX, ++count0);
                        }
                        if (result != 0) break; //если ответ не нуль, значит кто-то победил, прервем цикл
                        else if (countX == winCondition) { //Если количество иксов в строке равно условию победы
                            result = 1; //Значит победил игрок X
                        } else if (count0 == winCondition) result = 2; //Тоже самое для нуликов
                    }
                }
            }
            return result;
        }

        /**
         * Проверка победы одного из игроков, проверка ничьи
         * @return 0 - нет победы, 1 - победа игрока X, 2 - победа игрока, -1 - ничья
         */
        public static byte isGameEnd() {
            byte result;
            result = checkGameDeskRowsColumns ( true); //проверка строк
            if (result == 0) result = checkGameDeskRowsColumns(false); //проверка столбцов
            if (result == 0) result = checkGameDeskDiagonals(true); //Проверка диагонали 1
            if (result == 0) result = checkGameDeskDiagonals(false); //Проверка диагонали 2
            if (result == 0) if (isGameDeskFull()) result = -1; //Проверка ничьи
            switch (result) {
                case -1:
                    System.out.println("Ничья");
                    break;
                case 0:
                    System.out.println("Игра продолжается");
                    break;
                case 1:
                    System.out.println("Игра окончена, победил X");
                    break;
                case 2:
                    System.out.println("Игра окончена, победил 0");
                    break;
            }
            return result;
        }
    }


    public static void main(String[] args) {
        System.out.printf("Инициализация игры, размер поля %dx%d", GAME_DESK_SIZE, GAME_DESK_SIZE);
        System.out.println();
        GameMap gameMap = new GameMap(GAME_DESK_SIZE, GAME_WIN_CONDITION);
        do {
            if (gameMap.humanTurn (SKANNER.nextInt() - 1, SKANNER.nextInt() - 1)) gameMap.aiTurn();
            gameMap.paintDesk();
        } while (gameMap.isGameEnd() == 0);

    }
}
