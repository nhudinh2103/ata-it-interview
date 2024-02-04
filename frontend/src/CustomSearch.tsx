import { useEffect, useState } from "react";

import Table from "react-bootstrap/Table";
import "bootstrap/dist/css/bootstrap.min.css";
import { Button } from "react-bootstrap";
import { Input, MenuItem, Select } from "@mui/material";
import { DatePicker } from "@mui/x-date-pickers";
import moment from "moment";

interface UserData {
  account: string;
  operation: string;
  symbol: string;
  description: string;
  qty: string;
  filledQty: string;
  price: string;
  status: string;
  date: string;
  expiration: string;
  noRef: string;
  extRef: string;
}

const dummyData = [
  {
    account: "00000001",
    operation: "Buy",
    symbol: "NA",
    description: "NATIONAL BANK OF CDA",
    qty: "5",
    filledQty: "0",
    price: "526.00",
    status: "Waiting",
    date: "2022/12/08 05:12:36",
    expiration: "2022/12/08 05:12:36",
    noRef: "13830581",
    extRef: "2-XXXXXXX1-1",
  },
  {
    account: "00000002",
    operation: "Buy",
    symbol: "NA",
    description: "NATIONAL BANK OF CDA",
    qty: "90",
    filledQty: "0",
    price: "744.00",
    status: "Waiting",
    date: "2022/12/15 23:30:32",
    expiration: "2022/12/15 23:30:32",
    noRef: "20435409",
    extRef: "2-XXXXXXX1-2",
  },
  {
    account: "00000003",
    operation: "Buy",
    symbol: "NA",
    description: "NATIONAL BANK OF CDA",
    qty: "60",
    filledQty: "0",
    price: "369.00",
    status: "Waiting",
    date: "2023/01/04 02:57:35",
    expiration: "2023/01/04 02:57:35",
    noRef: "09612775",
    extRef: "2-XXXXXXX1-3",
  },
  {
    account: "00000004",
    operation: "Buy",
    symbol: "NA",
    description: "NATIONAL BANK OF CDA",
    qty: "1000",
    filledQty: "0",
    price: "909.00",
    status: "Waiting",
    date: "2023/01/04 03:05:44",
    expiration: "2023/01/04 03:05:44",
    noRef: "96674263",
    extRef: "2-XXXXXXX1-4",
  },
  {
    account: "00000005",
    operation: "Buy",
    symbol: "NA",
    description: "NATIONAL BANK OF CDA",
    qty: "800",
    filledQty: "0",
    price: "672.00",
    status: "Waiting",
    date: "2023/01/04 03:05:44",
    expiration: "2023/01/04 03:05:44",
    noRef: "61647068",
    extRef: "2-XXXXXXX1-6",
  },
];

function CustomSearch() {
  const [userData, setUserData] = useState<UserData[]>(dummyData);
  const [userSearchData, setUserSearchData] = useState<UserData[]>(dummyData);

  const [name, setName] = useState<string>("");

  const [fromDate, setFromDate] = useState<string | null>("");
  const [toDate, setToDate] = useState<string | null>("");

  const handleSearch = () => {

    let fromDateNumVal = -1;
    if (fromDate !== "" && fromDate !== null) {
      fromDateNumVal = new Date(fromDate).getTime();
    }

    let toDateNumVal = Number.MAX_SAFE_INTEGER;
    if (toDate !== "" && toDate !== null) {
      toDateNumVal = new Date(toDate).getTime();
    }

    if (fromDateNumVal > toDateNumVal) {
      alert("invalid search: from date is after to date => Please recheck against");
      return;
    }

    const newData = userData
      .filter((x) => x.account == (name == "" ? x.account : name))
      .filter((x) => {
        let rowDateNumVal = moment(x.date, "YYYY/MM/DD HH:mm:ss").valueOf();

        return fromDateNumVal <= rowDateNumVal && rowDateNumVal <= toDateNumVal;
      });
    setUserSearchData(newData);

  };

  return (
    <>
      <Table>
        <tbody>
          <tr>
            <td>
              <Input
                className="form-control"
                type="text"
                placeholder="Enter account no..."
                onChange={(e) => setName(e.target.value)}
              ></Input>
            </td>
            <td>
              <Select defaultValue="transmission">
                <option value="transmission">Transmission</option>
                {/* <MenuItem value='transmission'>Transmission</MenuItem> */}
              </Select>

              <Select defaultValue="waiting">
                <option value="waiting">Waiting</option>
                {/* <MenuItem value='transmission'>Transmission</MenuItem> */}
              </Select>

            </td>
            <td>
              <DatePicker
                label="Start Date"
                value={fromDate}
                onChange={(newValue) => {
                  setFromDate(newValue);
                }}
                format="DD/MM/YYYY"
              />
            </td>
            <td>
              <DatePicker
                label="End Date"
                value={toDate}
                onChange={(newValue) => {
                  setToDate(newValue);
                }}
                format="DD/MM/YYYY"
              />
            </td>
            <td>
              <Button className="btn btn-primary" onClick={handleSearch}>
                Search
              </Button>
            </td>
          </tr>
        </tbody>
      </Table>

      <Table responsive striped size="sm">
        <thead>
          <tr>
            <th>Account</th>
            <th>Operation</th>
            <th>Symbol</th>
            <th scope="col" className="d-none d-sm-table-cell">Description</th>
            <th scope="col" className="d-none d-sm-table-cell">Qty</th>
            <th scope="col" className="d-none d-sm-table-cell">Filled Qty</th>
            <th scope="col" className="d-none d-sm-table-cell">Price</th>
            <th>Status</th>
            <th scope="col" className="d-none d-sm-table-cell">Date</th>
            <th scope="col" className="d-none d-sm-table-cell">Expiration</th>
            <th scope="col" className="d-none d-sm-table-cell">No. Ref.</th>
            <th scope="col" className="d-none d-sm-table-cell">Ext. Ref.</th>
          </tr>
        </thead>
        <tbody>
          {userSearchData && userSearchData.length > 0
            ? userSearchData.map((item) => (
                <tr key={item.account}>
                  <td>{item.account}</td>
                  <td>{item.operation}</td>
                  <td>{item.symbol}</td>
                  <td scope="col" className="d-none d-sm-table-cell">{item.description}</td>
                  <td scope="col" className="d-none d-sm-table-cell">{item.qty}</td>
                  <td scope="col" className="d-none d-sm-table-cell">{item.filledQty}</td>
                  <td scope="col" className="d-none d-sm-table-cell">{item.price}</td>
                  <td>{item.status}</td>
                  <td scope="col" className="d-none d-sm-table-cell">{item.date}</td>
                  <td scope="col" className="d-none d-sm-table-cell">{item.expiration}</td>
                  <td scope="col" className="d-none d-sm-table-cell">{item.noRef}</td>
                  <td scope="col" className="d-none d-sm-table-cell">{item.extRef}</td>
                </tr>
              ))
            : undefined}
        </tbody>
      </Table>
    </>
  );
}

export default CustomSearch;
