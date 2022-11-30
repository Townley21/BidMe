//
//  MapViewController.swift
//  BidMe
//
//  Created by Axel Mora on 10/4/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

//Imported MapKit and CoreLocation
import MapKit
import UIKit

class MapViewController: UIViewController, MKMapViewDelegate {

    @IBOutlet var mapView : MKMapView!
        
    override func viewDidLoad() {
        super.viewDidLoad()
        mapView.delegate = self
        title = "Map Screen"
        // Do any additional setup after loading the view.
        createAnnotations(locations: annotationLocations)
    }
    
    let annotationLocations = [
        ["title": "Cronies Sports Grill" , "latitude": 34.220220153566146, "longitude": -119.05331693066982],
        ["title": "Instituiton Ale Company" , "latitude": 34.217176763461964, "longitude": -119.01923559884497],
        ["title": "Wood Ranch BBQ & Grill" , "latitude": 34.21901201556222, "longitude": -119.05528295282262],
        ["title": "Cagami Ramen" , "latitude": 34.21875832451282, "longitude": -119.04530720680104],
        ["title": "Ric's Restaurant and Sports Lounge" , "latitude": 34.236435424231395, "longitude": -119.03776751726916]
    ]
    
    func createAnnotations(locations: [[String: Any]]) {
        for location in locations {
            let annotations = MKPointAnnotation()
            annotations.title = location["title"] as? String
            annotations.coordinate = CLLocationCoordinate2D(latitude: location["latitude"] as! CLLocationDegrees, longitude: location["longitude"] as! CLLocationDegrees)
            mapView.addAnnotation(annotations)
        }
    }
    
    
    /*
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
    */
    
}
