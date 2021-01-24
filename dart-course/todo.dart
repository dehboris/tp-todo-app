import 'dart:io';

List dynamicList=new List();
var task;
void Tache(){
  
  print("Ajouter une tache:");
  task=stdin.readLineSync();
  dynamicList.add(task);  
}

void retirer(List dynamicList){
dynamicList.clear();
assert(dynamicList.isEmpty);
print("Votre liste de tache est desormais vide.");
}

void rechercher(List dynamicList){
  var valeurRecherche;
  print("Entrez le numéro de la tache:");
  valeurRecherche=stdin.readLineSync();
  for(var i=0;i<dynamicList.length;i++)
  {
    if(dynamicList.indexOf(task)==valeurRecherche){
    print(task);
  }
  else
  {
    print("La tache que vous recherchez n'existe pas");
  }
  
}

void supprimer(List dynamicList){
  var taskIndex;
  print("Entrez le numéro de la tache à supprimer");
   taskIndex=stdin.readLineSync();
  if(dynamicList.indexOf(task)==taskIndex)
  {
    dynamicList.removeAt(taskIndex);
  }
  else
  {
    print("Cette tache que vous voulez supprimer n'existe pas");
  }
}

void afficher(List dynamicList){
  for(var i=0;i<dynamicList.length;i++)
  {
    print(dynamicList);
  }
}


void main(List<String> args) {
  var choix;
  var liste=List();
  print("TO DO");
  do{
  print("1-Ajouter une tache");
  print("2-Retirer toutes les taches");
  print("3-Rechercher une tache");
  print("4-Supprimer une tache");
  print("5-Afficher les éléments de la liste:");
  print("Que voulez vous faire ?(Tapez un numéro)");
  choix=stdin.readLineSync();
  switch(choix)
  {
    case 1:
    Tache();
    break;
    case 2:
    retirer(liste);
    break;
    case 3:
    rechercher(liste);
    break;
    case 4:
    supprimer(liste);
    break;
    case 5:
    afficher(liste);
    break;
    default:
    print("Vous avez un mauvais choix. Veuillez tapez un numéro valide");
  }
  
  }while(choix!=5);
  
}
}