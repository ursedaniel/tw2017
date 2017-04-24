import { Component, OnInit } from '@angular/core';
import {Project} from "../../interfaces/Project";

@Component({
  selector: 'acar-allprojects',
  templateUrl: './allprojects.component.html',
  styleUrls: ['./allprojects.component.css']
})
export class AllprojectsComponent implements OnInit {

  projects: Array<Project> = [
    new Project(1,"Proiect 1","Mica descriere","proiect1.zip"),
    new Project(2,"Proiect 2","Mica descriere","proiect2.zip"),
    new Project(3,"Proiect 3","Mica descriere","proiect3.zip"),
    new Project(4,"Proiect 4","Mica descriere","proiect4.zip"),
    new Project(5,"Proiect 5","Mica descriere","proiect5.zip"),
    new Project(7,"Proiect 7","Mica descriere","proiect7.zip"),
    new Project(8,"Proiect 8","Mica descriere","proiect8.zip"),
    new Project(12,"Proiect 12","Mica descriere","proiect12.zip"),
    new Project(13,"Proiect 13","Mica descriere","proiect13.zip"),
    new Project(15,"Proiect 15","Mica descriere","proiect15.zip")
  ];


  constructor() { }

  ngOnInit() {
  }

}
