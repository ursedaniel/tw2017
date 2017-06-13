import { Component, OnInit } from '@angular/core';
import {Gossip} from "../../../../interfaces/Gossip";

@Component({
  selector: 'acar-teachergossips',
  templateUrl: './teachergossips.component.html',
  styleUrls: ['./teachergossips.component.css']
})
export class TeachergossipsComponent implements OnInit {

  gossips: any;

  constructor() { }

  ngOnInit() {
  }

}
