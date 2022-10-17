//
//  MapViewController.swift
//  BidMe
//
//  Created by Axel Mora on 10/4/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

//Imported MapKit and CoreLocation
import MapKit
import CoreLocation
import UIKit

class MapViewController: UIViewController, CLLocationManagerDelegate {

    @IBOutlet var mapView : MKMapView!
    
    let manager = CLLocationManager();
    
    override func viewDidLoad() {
        super.viewDidLoad()
        title = "Map Screen"
        // Do any additional setup after loading the view.
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated);
        manager.desiredAccuracy = kCLLocationAccuracyBest;
        manager.delegate = self;
        manager.requestWhenInUseAuthorization();
        manager.startUpdatingLocation();
        
    }
    
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        
        if let location = locations.first{
            manager.stopUpdatingLocation();
            render(location);
        }
    }
    
    func render(_ location : CLLocation) {
        
        let coordinate = CLLocationCoordinate2D(latitude: location.coordinate.latitude, longitude: location.coordinate.longitude);
        
        let span = MKCoordinateSpan(latitudeDelta: 0.1, longitudeDelta: 0.1);
        
        let region = MKCoordinateRegion(center: coordinate, span: span);
        
        mapView.setRegion(region, animated: true);
        
        let pin = MKPointAnnotation();
        pin.coordinate = coordinate;
        mapView.addAnnotation(pin);
    }
    
}
