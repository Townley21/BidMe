//
//  HistoryViewCell.swift
//  BidMe
//
//  Created by Brandon Townley on 10/16/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class HistoryViewCell: UITableViewCell {
    
    @IBOutlet var addressLabel: UILabel!
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
