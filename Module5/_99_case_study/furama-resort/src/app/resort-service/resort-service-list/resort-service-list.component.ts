import {Component, OnInit} from '@angular/core';
import {ResortServiceService} from '../services/resort-service.service';
import {IResortService} from '../models/resort-service';

@Component({
  selector: 'app-resort-service-list',
  templateUrl: './resort-service-list.component.html',
  styleUrls: ['./resort-service-list.component.scss']
})
export class ResortServiceListComponent implements OnInit {
  resortServices: IResortService[];
  page = 1;
  searchValue = '';
  selectedService: IResortService = {
    area: 0,
    id: 0,
    max_people: 0,
    name: '',
    price: 0,
    rent_type: '',
    service_id: ''
  };

  constructor(private resortServiceService: ResortServiceService) {
  }

  ngOnInit(): void {
    this.searchValue = '';
    this.resortServiceService.getAllServices().subscribe(data => {
      this.resortServices = data;
    });
  }

  doSearch() {
    this.page = 1;
    this.searchValue = this.searchValue.trim();
    this.resortServiceService.search(this.searchValue).subscribe(
      data => this.resortServices = data
    );
  }

  deleteService(id) {
    this.resortServiceService.getServiceById(id).subscribe(data => {
        this.resortServiceService.deleteService(id).subscribe(deletedData => {
          this.ngOnInit();
        });
      }
    );
  }

  selectService(resortService: IResortService) {
  this.selectedService = resortService;
  }
}
