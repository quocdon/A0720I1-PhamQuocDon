import { Component, OnInit } from '@angular/core';
import {IContract} from '../models/contract';
import {ContractService} from '../services/contract.service';
import {ICustomer} from '../../customer/models/customer';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.scss']
})
export class ContractListComponent implements OnInit {
  contracts: IContract[];
  page = 1;
  limit = 3;
  nextPage: IContract[];

  constructor(private contractService: ContractService) { }

  ngOnInit(): void {
    this.contractService.getContractsPagination(this.page, this.limit).subscribe(data => {
      this.contracts = data;
    });
    this.contractService.getContractsPagination(this.page + 1, this.limit).subscribe(data => {
      this.nextPage = data;
    });
  }

  doSearch(search: HTMLInputElement) {
  }

  previous() {
    this.page--;
    this.ngOnInit();
  }

  next() {
    this.page++;
    this.ngOnInit();
  }
}
