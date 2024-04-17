import { ShowData } from "./showData"

export interface BookingFormData {
    movieShow: {
        id: number
    },
    user: {
        id: number
    },
    totalBookedSeats: number
}

export interface BookingData {
    id: number,
    bookingDateTime: any,
    movieShow: ShowData,
    totalBookedSeats: number
}

export interface Booking {
    booking: BookingData
}