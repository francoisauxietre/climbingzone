/** "AbstractionRaffinée" */
class CircleShape implements Shape
{
  private double x, y, radius;
  private DrawingAPI drawingAPI;

  public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI)
  {
    this.x = x;  this.y = y;  this.radius = radius;
    this.drawingAPI = drawingAPI;
  }

  // bas niveau, càd spécifique à une implémentation
  public void draw()
  {
    drawingAPI.drawCircle(x, y, radius);
  }

  // haut niveau, càd spécifique à l'abstraction
  public void resizeByPercentage(double pct)
  {
    radius *= pct;
  }
}
