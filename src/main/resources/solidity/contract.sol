// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.15;


contract Ownable
{
    // Variable that maintains
    // owner address
    address private _owner;

    // Sets the original owner of
    // contract when it is deployed
    constructor()
    {
        _owner = msg.sender;
    }

    // Publicly exposes who is the
    // owner of this contract
    function owner() public view returns (address)
    {
        return _owner;
    }

    // onlyOwner modifier that validates only
    // if caller of function is contract owner,
    // otherwise not
    modifier onlyOwner()
    {
        require(isOwner(),
            "Function accessible only by the owner !!");
        _;
    }

    // function for owners to verify their ownership.
    // Returns true for owners otherwise false
    function isOwner() public view returns (bool)
    {
        return msg.sender == _owner;
    }
}

contract company is Ownable {
    mapping(address => bool) public verifiedCompany;

    function newCompany(address comp_addr) onlyOwner public {
        verifiedCompany[comp_addr] = false;
    }

    function Verfy_Comp(address comp_addr) onlyOwner public {
        verifiedCompany[comp_addr] = true;
    }

    function is_Verified(address comp_addr) view public returns (bool) {
        return verifiedCompany[comp_addr];
    }

    function delete_Comp(address comp_addr) onlyOwner public {
        delete verifiedCompany[comp_addr];

    }

    modifier  ver(address comp_addr) {
        require((is_Verified(comp_addr)),
            "Function accessible only by the owner !!");
        _;
    }

}

contract TransferToken is company {

    function receiveEth() public payable {

    }

    function getBal() public view returns (uint) {
        return address(this).balance;
    }

    function transferEth(address payable add, uint amt) public ver(add) {
        add.transfer(amt);
    }


}