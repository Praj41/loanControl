// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.15;

contract linkAccounts {
    mapping(uint256 => address) public physicalToDigitalAcc;

    function linkAccount(uint256 physicalAccount, address digitalAccount) public {
        physicalToDigitalAcc[physicalAccount] = digitalAccount;
    }

    function getDigitalAccount(uint256 physicalAccount) public view returns (address) {
        return physicalToDigitalAcc[physicalAccount];
    }

    function delete_account(uint256 physicalAccount) public {
        delete physicalToDigitalAcc[physicalAccount];
    }

}