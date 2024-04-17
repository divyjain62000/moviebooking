export interface PaymentData {
    paymentMode: string,
    booking: {
        id: number
    },
    status: string,
    totalAmount: number
}

export interface PaymentFormData {
    paymentMode: string,
    cardNumber: number,
    month: number,
    year: number,
    cvv: number
}