# CSGames2016-IngenierieLogicielle

Votre tâche est de créer une application de gestion des horaires pour une petite entreprise. Le programme devra lire les restrictions des employés dans un fichier (XML, YAML ou autre) et générer un horaire en fonction de ces restrictions. Si le programme est incapable de générer un horaire respectant toutes les restrictions, il devra l’indiquer et suggérer plusieurs (au moins deux) suggestions en mentionnant les restrictions n’ayant pas été respectées. Le programme doit afficher l’horaire dans une interface graphique.

Les heures d’ouverture de l’entreprise sont les suivantes:
- De 8h à 17h du lundi au mercredi
- De 8h à 21h du jeudi au samedi
- De 11h à 17h le dimanche
- De 13h à 16h30 les jours fériés

Un nombre prédéfini d’employés doit être présent à certaines périodes de la journée. Voici la répartition des équipes de travail:
- 2 personnes en avant-midi (jusqu’à 11h30)
- 4 personnes en après-midi (de 11h30 à 16h30)
- 3 personnes en soirée (à partir de 16h30)

Voici une liste des restrictions que le programme doit gérer:
- Nombre d’heures demandé par un employé
- Périodes d’indisponibilité d’un employé
- Nombre d’heures consécutives maximal d’un quart de travail
- Nombre d’heures consécutives minimal d’un quart de travail
- Incompatibilité avec d’autres employés (ne pas mettre les deux employés sur un même quart de travail)

Vous aurez 30 minutes en équipe au début de la compétition pour planifier le développement. Vous serez ensuite séparés pendant deux heures. Vous aurez finalement 30 minutes en équipe à la fin de la compétition pour terminer le projet.

Seul le langage Java est permis.
