## Klasserna och deras roller

"Programmet är uppdelat i fyra klasser:
1. `FifteenPuzzle` – Huvudklassen som startar spelet.
2. `PuzzleBoard` – Klassen som hanterar spelets logik, som att blanda brickor och flytta dem.
3. `PuzzleButton` – Representerar varje knapp i spelet.
4. `GameActionListener` – Hanterar knapptryckningarna för 'Nytt spel' och 'Demo-spel'."

---

## Huvudklassen `FifteenPuzzle`

`FifteenPuzzle` är huvudklassen som startar spelet. 
1. Här skapas en instans av `PuzzleBoard`, som representerar spelbrädet. 
2. Den skapar även två knappar, 'Nytt spel' och 'Demo-spel', och tilldelar dem en `GameActionListener`.

> **Kodexempel:**
> ```java
> board = new PuzzleBoard();
> newGameButton = new JButton("Nytt spel");
> demoButton = new JButton("Demo-spel");
> GameActionListener listener = new GameActionListener(board);
> ```

---

## Spelbrädet `PuzzleBoard`

`PuzzleBoard` är den största klassen och innehåller spelets huvudsakliga logik. Den ansvarar för att:
1. Skapa brickorna och placera dem på spelbrädet.
2. Blanda brickorna i början av spelet.
3. Flytta brickor och kontrollera om spelaren har vunnit."

> **Kodexempel:**
> - **Skapa och blanda brickor:**
>   ```java
>   initializeButtons();
>   shuffleTiles();
>   ```
> - **Flytta en bricka:**
>   ```java
>   if (Math.abs(row - emptyRow) == 1 && col == emptyCol) { ... }
>   ```

---

## Knappklassen `PuzzleButton`

1. `PuzzleButton` är en wrapper-klass för `JButton`
2. Den representerar varje bricka i spelet. 
3. Den tar in rad och kolumn som argument och använder detta för att identifiera varje knapp på spelbrädet. 
4. Varje knapp har även en egen `ActionListener` som triggar en flytt när man klickar på den."

> **Kodexempel:**
> ```java
> public PuzzleButton(int row, int col, PuzzleBoard board) {
>     button.addActionListener(new ActionListener() {
>         public void actionPerformed(ActionEvent e) {
>             board.moveTile(row, col);
>         }
>     });
> }
> ```

---

## `GameActionListener` för spelets kontroller

1. Klassen `GameActionListener` implementerar `ActionListener` 
2. Den hanterar spelets kontrollknappar, 'Nytt spel' och 'Demo-spel'. 
3. 'Nytt spel' blandar vi om brickorna 
4. 'Demo-spel' visar en nästan löst version av pusslet för demonstration.

> **Kodexempel:**
> ```java
> if (source.getText().equals("Nytt spel")) {
>     board.shuffleTiles();
> } else if (source.getText().equals("Demo-spel")) {
>     board.demoSolve();
> }
> ```

---

## Demo av spelet och avslutning

"Nu när vi har gått igenom koden ska jag visa en snabb demo av spelet."

1. Klicka på "Nytt spel" och visa att brickorna blandas.
2. Klicka på en av brickorna för att visa hur de flyttas.
3. Klicka på "Demo-spel" för att visa ett nästan löst läge.