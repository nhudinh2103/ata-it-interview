import { useEffect, useState } from "react";

import Table from "react-bootstrap/Table";
import "bootstrap/dist/css/bootstrap.min.css";

interface UserData {
  account: string,
  operation: string,
  symbol: string,
  description: string,
  qty: string,
  filledQty: string,
  price: string,
  status: string,
  date: string,
  expiration: string,
  noRef: string,
  extRef: string
}

function CustomSearch() {
  const [userData, setUserData] = useState<UserData[]>([]);
  const [name, setName] = useState<string>("");

  useEffect(() => {
    const data = [
      { account: "00000001", operation: "Buy", symbol: "NA", description: "NATIONAL BANK OF CDA", qty: "5", filledQty: "0", price: "526.00", status: "Waiting", date: "2022/12/22/05:12:36", expiration: "2022/12/22/05:12:36", noRef: "13830581", extRef: "2-XXXXXXX1-1"},
      { account: "00000001", operation: "Buy", symbol: "NA", description: "NATIONAL BANK OF CDA", qty: "5", filledQty: "0", price: "526.00", status: "Waiting", date: "2022/12/22/05:12:36", expiration: "2022/12/22/05:12:36", noRef: "13830581", extRef: "2-XXXXXXX1-1"},
    ];

    setUserData(data);
  }, []);

  const handleSearch = () => {
    alert("clicked");
  };

  return (
    <>
      <Table>
        <tbody>
        <tr>
          <td>
            <input
              type="text"
              placeholder="Enter name..."
              onChange={(e) => setName(e.target.value)}
            ></input>
          </td>
          <td>
            <button onClick={() => handleSearch}> Search</button>
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
            <th>Description</th>
            <th>Qty</th>
            <th>Filled Qty</th>
            <th>Price</th>
            <th>Status</th>
            <th>Date</th>
            <th>Expiration</th>
            <th>No. Ref.</th>
            <th>Ext. Ref.</th>
          </tr>
        </thead>
        <tbody>
          {userData && userData.length > 0
            ? userData.map((item) => (
                <tr key={item.account}>
                  <td>{item.account}</td>
                  <td>{item.operation}</td>
                  <td>{item.symbol}</td>
                  <td>{item.description}</td>
                  <td>{item.qty}</td>
                  <td>{item.filledQty}</td>
                  <td>{item.price}</td>
                  <td>{item.status}</td>
                  <td>{item.date}</td>
                  <td>{item.expiration}</td>
                  <td>{item.noRef}</td>
                  <td>{item.extRef}</td>
                </tr>
              ))
            : undefined}
        </tbody>
      </Table>
    </>
  );
}

export default CustomSearch;
