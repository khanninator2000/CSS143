class Picture {
      private Circle[] myCircles = new Circle[100];
      private int numCircles;

      private Square[] mySquares = new Square[100];
      private int numSquares;

      public void addCircle(Circle next) {
          myCircles[numCircles++] = next;
      }

      public void addSquare(Square next) {
          mySquares[numSquares++] = next;
      }

      public String toString() {
          String s = "";
          for (int i = 0; i < numCircles; s+=myCircles[i], i++);
          for (int i = 0; i < numSquares; s+=mySquares[i], i++);

          return s;
      }
}