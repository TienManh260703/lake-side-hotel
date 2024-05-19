import axios from 'axios'

export const api = axios.create({
    baseURL: "http://localhost:9192"
})

export const addRoom = async (photo, roomType, roomPrice) => {
    const formData = new FormData();
    formData.append("photo", photo)
    formData.append("roomType", roomType)
    formData.append("roomPrice", roomPrice)

    const response = await api.post("/rooms/add/new-room", formData, {
        headers: {
            'Content-Type': 'multipart/form-data'
        }
    });
    if (response.status === 201) {
        return true;
    }
    return false;
}


export const getRoomTypes = async () => {
    try {
        const response = await api.get('/rooms/room-types');
        return response.data;
    } catch (error) {
        console.error('Error fetching room types:', error);
        throw new Error("Error fetching room types");
    }
};
