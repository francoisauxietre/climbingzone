/// <summary> "Adaptateur" qui encapsule un objet qui n'a pas la bonne signature</summary>
class Application implements IDeveloppeur
  {
  Architecte architecte;
public Adaptateur (Architecte archi)
  {
  this.architecte = archi;
  }
public string EcrireCode()
  {
  return string.Format(
  "let main() = printfn \"{0} codé\"",
  this._architecte.EcrireAlgorithme());
  }
  }
