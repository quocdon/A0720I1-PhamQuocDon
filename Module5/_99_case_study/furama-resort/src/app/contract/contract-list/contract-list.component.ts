import {Component, OnInit} from '@angular/core';
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
  searchValue = '';

  constructor(private contractService: ContractService) {
  }

  ngOnInit(): void {
    this.searchValue = '';
    this.contractService.getAllContracts().subscribe(
      data => this.contracts = data
    );
  }

  doSearch(searchOption) {
    this.page = 1;
    const option = searchOption.value;
    this.contractService.search(this.searchValue, option).subscribe(
      data => this.contracts = data
    );
  }
}
