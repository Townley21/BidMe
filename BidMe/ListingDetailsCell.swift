//
//  ListingDetailsCell.swift
//  BidMe
//
//  Created by Brandon Townley on 10/9/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class ListingDetailsCell: UITableViewCell {
    
    @IBOutlet var contractorLabel: UILabel!
    @IBOutlet var priceLabel: UILabel!

    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
