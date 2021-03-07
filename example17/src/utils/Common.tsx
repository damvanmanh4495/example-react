export let axios_config = (token: string | null) => {
    return {
        headers : {
            "Authorization": "Bearer " + token,
        }
    }
}