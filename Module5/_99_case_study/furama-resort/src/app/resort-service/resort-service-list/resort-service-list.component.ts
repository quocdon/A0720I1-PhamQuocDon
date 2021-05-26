import { Component, OnInit } from '@angular/core';
import {ResortServiceService} from '../services/resort-service.service';
import {IResortService} from '../models/resort-service';

@Component({
  selector: 'app-resort-service-list',
  templateUrl: './resort-service-list.component.html',
  styleUrls: ['./resort-service-list.component.scss']
})
export class ResortServiceListComponent implements OnInit {
  resortServices: IResortService[];
  constructor(private resortServiceService: ResortServiceService) { }

  ngOnInit(): void {
    this.resortServiceService.getAllServices().subscribe(data => {
      this.resortServices = data;
    });
  }

  doSearch(search) {
    const searchValue = search.value;
    this.resortServiceService.search(searchValue).subscribe(data => {
      this.resortServices = data;
    });
  }

  deleteService(id) {
    this.resortServiceService.getServiceById(id).subscribe(data => {
      if (confirm('Bạn muốn xóa dịch vụ ' + data.name + ' không?')){
        this.resortServiceService.deleteService(id).subscribe(deletedData => {
          alert('Xóa thành công dịch vụ ' + data.name);
          this.ngOnInit();
        });
      }
    });
  }
}
