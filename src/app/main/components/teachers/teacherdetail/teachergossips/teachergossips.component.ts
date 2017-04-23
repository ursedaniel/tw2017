import { Component, OnInit } from '@angular/core';
import {Gossip} from "../../../../interfaces/Gossip";

@Component({
  selector: 'acar-teachergossips',
  templateUrl: './teachergossips.component.html',
  styleUrls: ['./teachergossips.component.css']
})
export class TeachergossipsComponent implements OnInit {

  gossips: Array<Gossip> = [
    new Gossip(1,"Barfa 1","12/03/2017 22:30","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis feugiat mauris non congue pulvinar. Praesent congue sodales nunc, non pharetra neque sodales et. Praesent quis fermentum nisi. Proin a placerat metus. Sed vel pulvinar nibh. Quisque sollicitudin, orci sed iaculis sollicitudin, nisl ex placerat eros, sit amet faucibus urna lectus ac sapien. Morbi molestie congue lectus, fringilla faucibus justo sodales ut. In sodales ultrices sollicitudin."),
    new Gossip(2,"Barfa 2","27/05/2017 06:14","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis feugiat mauris non congue pulvinar. Praesent congue sodales nunc, non pharetra neque sodales et. Praesent quis fermentum nisi. Proin a placerat metus. Sed vel pulvinar nibh. Quisque sollicitudin, orci sed iaculis sollicitudin, nisl ex placerat eros, sit amet faucibus urna lectus ac sapien. Morbi molestie congue lectus, fringilla faucibus justo sodales ut. In sodales ultrices sollicitudin."),
    new Gossip(3,"Barfa 3","17/08/2016 09:24","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis feugiat mauris non congue pulvinar. Praesent congue sodales nunc, non pharetra neque sodales et. Praesent quis fermentum nisi. Proin a placerat metus. Sed vel pulvinar nibh. Quisque sollicitudin, orci sed iaculis sollicitudin, nisl ex placerat eros, sit amet faucibus urna lectus ac sapien. Morbi molestie congue lectus, fringilla faucibus justo sodales ut. In sodales ultrices sollicitudin."),
    new Gossip(4,"Barfa 4","26/09/2016 13:29","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis feugiat mauris non congue pulvinar. Praesent congue sodales nunc, non pharetra neque sodales et. Praesent quis fermentum nisi. Proin a placerat metus. Sed vel pulvinar nibh. Quisque sollicitudin, orci sed iaculis sollicitudin, nisl ex placerat eros, sit amet faucibus urna lectus ac sapien. Morbi molestie congue lectus, fringilla faucibus justo sodales ut. In sodales ultrices sollicitudin."),
    new Gossip(5,"Barfa 5","18/12/2015 23:36","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis feugiat mauris non congue pulvinar. Praesent congue sodales nunc, non pharetra neque sodales et. Praesent quis fermentum nisi. Proin a placerat metus. Sed vel pulvinar nibh. Quisque sollicitudin, orci sed iaculis sollicitudin, nisl ex placerat eros, sit amet faucibus urna lectus ac sapien. Morbi molestie congue lectus, fringilla faucibus justo sodales ut. In sodales ultrices sollicitudin."),
    new Gossip(6,"Barfa 6","31/03/2015 12:02","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis feugiat mauris non congue pulvinar. Praesent congue sodales nunc, non pharetra neque sodales et. Praesent quis fermentum nisi. Proin a placerat metus. Sed vel pulvinar nibh. Quisque sollicitudin, orci sed iaculis sollicitudin, nisl ex placerat eros, sit amet faucibus urna lectus ac sapien. Morbi molestie congue lectus, fringilla faucibus justo sodales ut. In sodales ultrices sollicitudin."),
    new Gossip(7,"Barfa 7","09/02/2014 03:45","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis feugiat mauris non congue pulvinar. Praesent congue sodales nunc, non pharetra neque sodales et. Praesent quis fermentum nisi. Proin a placerat metus. Sed vel pulvinar nibh. Quisque sollicitudin, orci sed iaculis sollicitudin, nisl ex placerat eros, sit amet faucibus urna lectus ac sapien. Morbi molestie congue lectus, fringilla faucibus justo sodales ut. In sodales ultrices sollicitudin."),
    new Gossip(8,"Barfa 8","04/11/2013 17:59","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis feugiat mauris non congue pulvinar. Praesent congue sodales nunc, non pharetra neque sodales et. Praesent quis fermentum nisi. Proin a placerat metus. Sed vel pulvinar nibh. Quisque sollicitudin, orci sed iaculis sollicitudin, nisl ex placerat eros, sit amet faucibus urna lectus ac sapien. Morbi molestie congue lectus, fringilla faucibus justo sodales ut. In sodales ultrices sollicitudin.")
  ];

  constructor() { }

  ngOnInit() {
  }

}
