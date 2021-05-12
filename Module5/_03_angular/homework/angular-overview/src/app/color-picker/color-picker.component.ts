import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-color-picker',
  templateUrl: './color-picker.component.html',
  styleUrls: ['./color-picker.component.css']
})
export class ColorPickerComponent implements OnInit {

  background = '#f93301';

  constructor() {
  }

  onChange(color){
    this.background = color;
  }

  ngOnInit(): void {
  }

}
